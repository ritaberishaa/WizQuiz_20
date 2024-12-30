package com.example.wizquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity {

    private EditText etQuestion, etAnswer;
    private Button btnAdd, btnUpdate, btnDelete;
    private ListView lvFlashcards;

    private AppDatabase database;
    private FlashcardDao flashcardDao;
    private List<Flashcard> flashcardList;
    private ArrayAdapter<String> adapter;
    private int selectedFlashcardId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        Log.d("FlashcardActivity", "Activity started");

        // Initialize Views
        etQuestion = findViewById(R.id.et_question);
        etAnswer = findViewById(R.id.et_answer);
        btnAdd = findViewById(R.id.btn_add);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        lvFlashcards = findViewById(R.id.lv_flashcards);

        // Initialize Database
        database = AppDatabase.getInstance(this);
        flashcardDao = database.flashcardDao();

        Log.d("FlashcardActivity", "Database initialized");

        if (flashcardDao.getAllFlashcards().isEmpty()) {
            flashcardDao.insert(new Flashcard("What is the capital of France?", "Paris"));
            flashcardDao.insert(new Flashcard("What is 2+2?", "4"));
            Log.d("FlashcardActivity", "Test data added");
        }

        // Load Flashcards
        loadFlashcards();

        // Set Listeners
        btnAdd.setOnClickListener(v -> addFlashcard());
        btnUpdate.setOnClickListener(v -> updateFlashcard());
        btnDelete.setOnClickListener(v -> deleteFlashcard());

        lvFlashcards.setOnItemClickListener((parent, view, position, id) -> {
            Flashcard selected = flashcardList.get(position);
            selectedFlashcardId = selected.getId();
            etQuestion.setText(selected.getQuestion());
            etAnswer.setText(selected.getAnswer());
        });
    }

    private void loadFlashcards() {
        flashcardList = flashcardDao.getAllFlashcards();
        Log.d("FlashcardActivity", "Loaded flashcards: " + flashcardList.size());
        List<String> flashcardStrings = new ArrayList<>();
        for (Flashcard flashcard : flashcardList) {
            flashcardStrings.add(flashcard.getQuestion() + " - " + flashcard.getAnswer());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flashcardStrings);
        Log.d("FlashcardActivity", "Adapter set with flashcards");
        lvFlashcards.setAdapter(adapter);
    }

    private void addFlashcard() {
        String question = etQuestion.getText().toString().trim();
        String answer = etAnswer.getText().toString().trim();

        if (question.isEmpty() || answer.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Flashcard flashcard = new Flashcard(question, answer);
        flashcardDao.insert(flashcard);
        Toast.makeText(this, "Flashcard added", Toast.LENGTH_SHORT).show();
        loadFlashcards();
        clearInputFields();
    }

    private void updateFlashcard() {
        if (selectedFlashcardId == -1) {
            Toast.makeText(this, "Please select a flashcard to update", Toast.LENGTH_SHORT).show();
            return;
        }

        String question = etQuestion.getText().toString().trim();
        String answer = etAnswer.getText().toString().trim();

        if (question.isEmpty() || answer.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Flashcard flashcard = new Flashcard(question, answer);
        flashcard.setId(selectedFlashcardId);
        flashcardDao.update(flashcard);
        Toast.makeText(this, "Flashcard updated", Toast.LENGTH_SHORT).show();
        loadFlashcards();
        clearInputFields();
        selectedFlashcardId = -1;
    }

    private void deleteFlashcard() {
        if (selectedFlashcardId == -1) {
            Toast.makeText(this, "Please select a flashcard to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        Flashcard flashcard = flashcardList.stream()
                .filter(f -> f.getId() == selectedFlashcardId)
                .findFirst()
                .orElse(null);

        if (flashcard == null) {
            Toast.makeText(this, "Selected flashcard not found", Toast.LENGTH_SHORT).show();
            return;
        }

        flashcardDao.delete(flashcard);
        Toast.makeText(this, "Flashcard deleted", Toast.LENGTH_SHORT).show();
        loadFlashcards();
        clearInputFields();
        selectedFlashcardId = -1;
    }

    private void clearInputFields() {
        etQuestion.setText("");
        etAnswer.setText("");
    }
}
