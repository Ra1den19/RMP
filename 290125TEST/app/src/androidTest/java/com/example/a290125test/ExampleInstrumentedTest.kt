package com.example.a290125test

import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.regex.Pattern.matches

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    // Тест нажатия на кнопку с проверкой изменения данных
    @Test
    fun testButtonClickChangesText() {
        // Предположим, что изначально TextView имеет текст "Hello"
        onView(withId(R.id.button)).perform(click())
        // Проверяем, что текст изменился на "Button Clicked"
        onView(withId(R.id.textView)).check(matches(withText("Button Clicked")))
    }

    // Проверка на вводимые данные
    @Test
    fun testInputText() {
        onView(withId(R.id.editText)).perform(typeText("Hello World"))
        // Проверяем, что текст ввода соответствует "Hello World"
        onView(withId(R.id.editText)).check(matches(withText("Hello World")))
    }

    // Тест перехода между экранами
    @Test
    fun testNavigation() {
        // Предположим, что у вас есть кнопка для перехода на новый экран
        onView(withId(R.id.buttonNavigate)).perform(click())
        // Проверяем, что новый экран отображает правильный элемент
        onView(withId(R.id.newScreenTextView)).check(matches(isDisplayed()))
    }

    // Тест выбора элемента списка
    @Test
    fun testListItemSelection() {
        // Предположим, что у вас есть RecyclerView с элементами
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<YourViewHolder>(0, click()))
        // Проверяем, что выбранный элемент отображает нужный текст
        onView(withId(R.id.selectedItemTextView)).check(matches(withText("Выбранный элемент")))
    }

    // Проверка отображения элементов
    @Test
    fun testElementsAreDisplayed() {
        // Проверяем, что элементы отображаются на экране
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextText)).check(matches(isDisplayed()))
    }
}