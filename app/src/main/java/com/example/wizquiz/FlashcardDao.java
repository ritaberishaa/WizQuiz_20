package com.example.wizquiz;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FlashcardDao {

    // Inserts a new flashcard into the database
    @Insert
    void insert(Flashcard flashcard);

    // Updates an existing flashcard in the database
    @Update
    void update(Flashcard flashcard);

    // Deletes a flashcard from the database
    @Delete
    void delete(Flashcard flashcard);

    // Retrieves all flashcards from the database
    @Query("SELECT * FROM flashcards")
    List<Flashcard> getAllFlashcards();

}