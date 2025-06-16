package template.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Query("SELECT * FROM TemplateEntity")
    fun getAllTemplateAsFlow(): Flow<List<TemplateEntity>>

    @Query("SELECT * FROM TemplateEntity")
    suspend fun getAllTemplate(): List<TemplateEntity>

    @Upsert
    suspend fun upsertTemplate(template: TemplateEntity)
}
