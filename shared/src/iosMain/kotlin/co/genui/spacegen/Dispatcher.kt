package co.genui.spacegen

import kotlinx.coroutines.*
import platform.Foundation.*
import platform.UIKit.*
import platform.darwin.*
import kotlin.coroutines.*

internal actual fun dispatcher(): CoroutineDispatcher = IosMainDispatcher

private object IosMainDispatcher : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }
}

