package template.error

import com.lunabee.lbcore.model.LBResult

data class CoreError(
    override val message: String? = null,
    override val cause: Throwable? = null,
    val code: ErrorCode = ErrorCode.Unknown,
) : Exception(message, cause) {
    enum class ErrorCode {
        Unknown,
    }

    companion object {
        inline fun <R> runCatching(
            noinline mapErr: ((CoreError) -> CoreError)? = null,
            block: () -> R,
        ): LBResult<R> {
            return try {
                LBResult.Success(block())
            } catch (e: CoreError) {
                val error = mapErr?.invoke(e) ?: e
                LBResult.Failure(error)
            }
        }
    }
}
