package com.example.a290125test

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

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
        onView(withId(R.id.editTextText)).perform(typeText("Hello World"))
        // Проверяем, что текст ввода соответствует "Hello World"
        onView(withId(R.id.editTextText)).check(matches(withText("Hello World")))
    }

    // Тест перехода между экранами
    @Test
    fun testNavigation() {
        // Предположим, что у вас есть кнопка для перехода на новый экран
        onView(withId(R.id.button)).perform(click())
        // Проверяем, что новый экран отображает правильный элемент
        onView(withId(R.id.textView2)).check(matches(isDisplayed()))
    }

    // Тест выбора элемента списка
    @Test
    fun testSelectItemFromList() {
        // Находим список и выбираем элемент с текстом "Item 1"
        onView(withId(R.id.ListView)).perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
            hasDescendant(withText("Item 1")), click()))

        // Проверяем, что текст в TextView изменился на выбранный элемент
        onView(withId(R.id.textView3)).check(matches(withText("Item 1")))
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