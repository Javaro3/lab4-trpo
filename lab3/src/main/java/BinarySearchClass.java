/**
 * Класс для бинарного поиска
 */
public class BinarySearchClass {
    /**
     * Массив на которым будет производится бинарный поиск
     */
    private int[] arr;

    public BinarySearchClass(int[] arr){
        this.arr = arr;
        sort();
    }

    /**
     * Сортирует массив чисел по возрастанию
     */
    private void sort(){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    /**
     * Бинарный поиск
     * @param elem элемент который надо найти
     * @param min нижняя грань поиска
     * @param max верхняя грань поиска
     * @return индекс элемента в массиве
     */
    public int binarySearch(int elem, int min, int max){
        int sred = (max + min) / 2;
        if(elem < arr[0] || elem > arr[arr.length-1]){
            return -1;
        }
        if(arr[sred] > elem){
            return binarySearch(elem, min, sred);
        } else if(arr[sred] < elem){
            return binarySearch(elem, sred, max);
        }
        return sred;
    }
}