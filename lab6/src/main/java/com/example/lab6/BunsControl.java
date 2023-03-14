package com.example.lab6;

import com.example.Buns.Bun;
import com.example.Ingredients.Ingredient;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BunsControl {
    private ArrayList<Bun> buns;

    public BunsControl(ArrayList<Bun> buns){
        this.buns = buns;
    }

    public BunsControl(){
        this.buns = new ArrayList<>();
    }

    /**
     * Добавляет булочку в конец списка
     * @param bun булочка которую надо добавить
     */
    public void addBun(Bun bun){
        buns.add(bun);
    }

    /**
     * Возвращает булочку по индексу если такой нет то возвращает null
     * @param index Индекс булочки в списке
     * @return Булочка с индексом index
     */
    public Bun GetBunByIndex(int index){
        return index < 0 || index > buns.size() ? null : buns.get(index);
    }


    /**
     * Удаляет булочку по индексу есл такой нет то возвращает null
     * @param index Индекс булочки в списке
     * @return Если булочка по такому индексу есть в списке возвращает ее если такого индекса нет в списке возвращает null
     */
    public Bun removeBunByIndex(int index) {
        return index < 0 || index > buns.size() ? null : buns.remove(index);
    }

    /**
     * Заменяет булочку с указанным индексом на переданную
     * @param index Индекс булочки в списке
     * @param bun Булочка котороя будет заменена под номером index
     * @return Если такой индекс есть в списке возвращает булочку если такого индекса нет в списке возвращает null
     */
    public Bun setNewBunByIndex(int index, Bun bun){
        return index < 0 || index > buns.size() ? null : buns.set(index, bun);
    }

    /**
     * Метод находит список булочек сделанных 5 мин. назад
     * @param currentTime Текущее время
     * @return Список булочек которые были сделаны 5 мин. назад
     */
    public ArrayList<Bun> getBunsMake5MinutesAgo(LocalTime currentTime){
        return (ArrayList<Bun>) buns.stream()
                .filter(bun -> ChronoUnit.MINUTES.between(currentTime, bun.getDateTime()) == -5)
                .collect(Collectors.toList());
    }

    /**
     * Находит булочки в которых есть ингредиент перец
     * @return Список булочек в которые содержится перец
     */
    public ArrayList<Bun> getBunsWithPepper(){
        return (ArrayList<Bun>) buns.stream()
                .filter(bun -> bun.findIngredient(new Ingredient("Перец")))
                .collect(Collectors.toList());
    }


    public ArrayList<Bun> getBuns(){
        return buns;
    }
}