package com.example.wizquiz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Flashcard.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;

    public abstract FlashcardDao flashcardDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class, "flashcard_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}
