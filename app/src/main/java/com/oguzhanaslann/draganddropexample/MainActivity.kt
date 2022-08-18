package com.oguzhanaslann.draganddropexample

import android.content.ClipData
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.DRAG_FLAG_GLOBAL
import android.view.View.DRAG_FLAG_GLOBAL_URI_READ
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.DragStartHelper
import androidx.draganddrop.DropHelper
import com.oguzhanaslann.draganddropexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setDragAndDropForHat()
        setDragAndDropForBody()
        setDragAndDropForPaths()
    }

    private fun setDragAndDropForPaths() {
        DropHelper.configureView(
            this,
            binding.panthsImageView,
            arrayOf(MIMETYPE_TEXT_PLAIN, "image/*"),
            DropHelper.Options.Builder()
                .setHighlightColor(Color.GREEN)
                .build()
        ) { _, payload ->
            Log.e("TAG", "onCreate: ${payload.clip.description.label} ")
            val isBody = binding.panthsImage.tag == payload.clip.description.label
            if (isBody) {
                binding.panthsImageView.setImageBitmap(binding.panthsImage.drawable.toBitmap())
            }

            null
        }





        DragStartHelper(binding.panthsImage) { view, _ ->
            // Sets the appropriate MIME types automatically.
            view.tag = "content://com.oguzhanaslann.draganddropexample/panthsImage"
            val data = ClipData(
                view.tag as CharSequence,
                arrayOf(MIMETYPE_TEXT_PLAIN),
                ClipData.Item(view.tag as CharSequence)
            )
            val dragShadow = View.DragShadowBuilder(view)

            view.startDragAndDrop(
                data,
                dragShadow,
                null,
                DRAG_FLAG_GLOBAL or DRAG_FLAG_GLOBAL_URI_READ
            )
        }.attach()
    }

    private fun setDragAndDropForBody() {
        DropHelper.configureView(
            this,
            binding.bodyImageView,
            arrayOf(MIMETYPE_TEXT_PLAIN, "image/*"),
            DropHelper.Options.Builder()
                .setHighlightColor(Color.GREEN)
                .build()
        ) { _, payload ->
            Log.e("TAG", "onCreate: ${payload.clip.description.label} ")
            val isBody = binding.bodyImage.tag == payload.clip.description.label
            if (isBody) {
                binding.bodyImageView.setImageBitmap(binding.bodyImage.drawable.toBitmap())
            }

            null
        }

        DragStartHelper(binding.bodyImage) { view, _ ->
            view.tag = "content://com.oguzhanaslann.draganddropexample/bodyImage"
            val data = ClipData(
                view.tag as CharSequence,
                arrayOf(MIMETYPE_TEXT_PLAIN),
                ClipData.Item(view.tag as CharSequence)
            )
            val dragShadow = View.DragShadowBuilder(view)

            view.startDragAndDrop(
                data,
                dragShadow,
                null,
                DRAG_FLAG_GLOBAL or DRAG_FLAG_GLOBAL_URI_READ
            )
        }.attach()
    }

    private fun setDragAndDropForHat() {
        DropHelper.configureView(
            this,
            binding.hatImageView,
            arrayOf(MIMETYPE_TEXT_PLAIN, "image/*"),
            DropHelper.Options.Builder()
                .setHighlightColor(Color.GREEN)
                .build()
        ) { _, payload ->
            Log.e("TAG", "onCreate: ${payload.clip.description.label} ")
            val isHat = binding.hatImage.tag == payload.clip.description.label
            if (isHat) {
                binding.hatImageView.setImageBitmap(binding.hatImage.drawable.toBitmap())
            }

            null
        }

        DragStartHelper(binding.hatImage) { view, _ ->
            view.tag = "content://com.oguzhanaslann.draganddropexample/hatImage"
            val data = ClipData(
                view.tag as CharSequence,
                arrayOf(MIMETYPE_TEXT_PLAIN),
                ClipData.Item(view.tag as CharSequence)
            )
            val dragShadow = View.DragShadowBuilder(view)

            view.startDragAndDrop(
                data,
                dragShadow,
                null,
                DRAG_FLAG_GLOBAL or DRAG_FLAG_GLOBAL_URI_READ
            )
        }.attach()
    }
}
