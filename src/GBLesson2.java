import java.util.Arrays;

public class GBLesson2 {

    public static void main(String[] args) {

       System.out.println("Task 1");
        printReverseIntBinnaryArray();


        System.out.println("\n\nTask 2");
        printLoopMultArray();


        System.out.println("\n\nTask 3");
        printLoopFindMultArray();


        System.out.println("\n\nTask 4");
        printSquareArray();


        System.out.println("\n\nTask 5");
        printMinMax();


        System.out.println("\n\nTask 6");
        int[] balancedArray1 = {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println(Arrays.toString(balancedArray1));

        if (!checkBalance( balancedArray1 )) {
            System.out.println("Array has no balanced parts");
        }

        System.out.println();

        int[] balancedArray2 = {1, 1, 1, 2, 1};

        System.out.println(Arrays.toString(balancedArray2));
        if (!checkBalance( balancedArray2 )) {
            System.out.println("Array has no balanced parts");
        }

        System.out.println();

        int[] balancedArray3 = {7, 1, 5, -33, 12, 7, 0, -1, 0, 9, 7};
        System.out.println(Arrays.toString(balancedArray3));
        if (!checkBalance( balancedArray3 )) {
            System.out.println("Array has no balanced parts");
        }

        System.out.println();

        int[] imbalancedArray1 = {1, 7, 4, -2, 5};
        System.out.println(Arrays.toString(imbalancedArray1));
        if (!checkBalance( imbalancedArray1 )) {
            System.out.println("Array has no balanced parts");
        }


        System.out.println("\n\nTask 7");
        int[]  arrayToRotate = {7,4,1,3,2,6,5,0,2,6,9};

        //Массив передается по ссылке, поэтому значения arrayToRotate крутятся
        System.out.println(Arrays.toString(arrayToRotate));

        System.out.println("Right, 3");
        System.out.println(Arrays.toString(rotateArray(arrayToRotate, 3)));

        System.out.println("Left, -20");
        System.out.println(Arrays.toString(rotateArray(arrayToRotate, -20)));

        System.out.println("Zero, 0");
        System.out.println(Arrays.toString(rotateArray(arrayToRotate, 0)));

        System.out.println("Zero, length");
        System.out.println(Arrays.toString(rotateArray(arrayToRotate, arrayToRotate.length)));



    }


    /**
     * *Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * */
    public static void printReverseIntBinnaryArray(){
        int[] constArray = {1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0};

        //Вывод до обработки
        System.out.println(Arrays.toString(constArray));

        for (int i = 0; i < constArray.length; i++) {
            constArray[i] = constArray[i] == 0 ? 1 : 0;
        }

        //Вывод после обработки
        System.out.println(Arrays.toString(constArray));
    }

    /**
     * Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     * */
    public static void printLoopMultArray(){
        int[] varArray = new int[8];

        for (int i = 0; i < 8; i++) {
            varArray[i] = i * 3;
        }

        System.out.println(Arrays.toString(varArray));
    }


    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     * */
    public static void printLoopFindMultArray(){

        int[] constArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println(Arrays.toString(constArray));

        for (int i = 0; i < constArray.length; i++) {
            if(constArray[i] < 6){
                constArray[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(constArray));
    }


    /**
     *Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     */
    public static void printSquareArray(){

        int[][] varArray = new int[7][7];

        for (int[] ints : varArray) {
            System.out.println(Arrays.toString(ints));
        }

        for (int i = 0; i < varArray.length ; i++) {
            varArray[i][i] = 1;
            varArray[i][varArray.length - i - 1] = 1;
        }

        System.out.println();
        for (int[] ints : varArray) {
            System.out.println(Arrays.toString(ints));
        }
    }



    /**
     *Задать одномерный массив и найти в нем минимальный и максимальный элементы
     */
    public static void printMinMax(){
        int[] constArray = {-3, 9, 12, -15, 0, 11, 4, 1, 30, -23, 6};
        int minVal;
        int maxVal;

        System.out.println(Arrays.toString(constArray));

        if (constArray.length >= 0){
            minVal = constArray[0];
            maxVal = constArray[0];
            if (constArray.length > 0){
                for (int i = 1; i < constArray.length; i++){
                    if (constArray[i] > maxVal) maxVal = constArray[i];
                    if (constArray[i] < minVal) minVal = constArray[i];
                }
            }
            System.out.println("MinVal = " + minVal);
            System.out.println("MaxVal = " + maxVal);

        }


    }


    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     * если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean checkBalance(int[] balanceArray){
        if (balanceArray.length <= 1){
            System.out.println("Array length error! Expected 2 or more items!");
            return false;
        }
        /*Используем вспомогательный массив, содержащий кумулятивную сумму - это уменьшает количество итераций,
        т.к. не нужно каждый раз считать сумму слева и справа от сплита, но ест дополнительную память*/

        int[] sumArray = new int[balanceArray.length];

        sumArray[0] = balanceArray[0];
        for (int i = 1; i < balanceArray.length; i++) {
            sumArray[i] = sumArray[i-1] + balanceArray[i];
        }

        /*Если последний элемент суммы нечетный для целочисленного массива, баланса быть не может,
        т.к. баланс это два одинаковых числа. Сумма 2х одинаковых целых чисел всегда четная.*/
        if (sumArray[sumArray.length - 1] % 2 != 0) return false;


        /*Если удвоенное значение текущего элемента равно сумме всех элементов массива - это точка баланса.
        В массиве таких точек может быть несколько (если он нулевой или содержит отрицательные элементы)
        поэтому ищем и показываем первую*/

        for (int i = 0; i < sumArray.length - 1; i++) {

            if (sumArray[sumArray.length - 1] == sumArray[i] * 2){
                System.out.println("First balance border position between " + (i + 1) + " and " + (i + 2) );
                System.out.println("First balance border elements " + sumArray[i] + " and " + sumArray[i + 1]);
                System.out.println("First balance sum = " + sumArray[i]);
                return true;
            }
        }

        return false;
    }

    /**
     *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     *при этом метод должен сместить все элементы массива на n позиций.
     *Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static int[] rotateArray(int[] arrayToRotate, int rotateVal){

        int val = 0; //Запомненное значение
        int pos = 0; //Ячейка, значение которой мы сдвигаем
        int newpos;  //Новая ячейка для сдвинутого значения
        int xpos = -1; //Указывает на ячейку, значение из которой мы забрали, но туда ничего не положили
        boolean noVal = true; //Истина, если val не содержит запомненного значения
        int tempval;

        //Если шагов вращения больше, чем количество элементов в массиве - отрежем лишние круги, это не карусель
        if ( Math.abs(rotateVal) >= arrayToRotate.length) {
            rotateVal = rotateVal % arrayToRotate.length;
        }

        for (int i = 0; i < arrayToRotate.length && rotateVal != 0; i++) {

            //Вычисляем новую позицию для текущего элемента
            newpos = pos + rotateVal;

            //Если курсоры вышли за пределы массива вправо или влево
            if (newpos > (arrayToRotate.length - 1)) newpos = newpos - arrayToRotate.length;
            if (newpos < 0) newpos = arrayToRotate.length + newpos;

            if (pos > (arrayToRotate.length - 1)) pos = pos - arrayToRotate.length;
            if (pos < 0) pos = arrayToRotate.length + pos;


            //Если нет никакого запомненного значения - берем значение текущей ячейки и помечаем её пустой
            if (noVal) {
                val = arrayToRotate[pos];
                xpos = pos;
                noVal = false;
            }

            if (newpos != xpos) {
                //Записываем запомненное значение в ячейку со сдвигом. При этом запоминаем значение, которое было в ней до этого
                tempval = arrayToRotate[newpos];
                arrayToRotate[newpos] = val;
                val = tempval;
            } else {
                //Если ячейка на которую мы пришли пустая и не содержит значения, запишем в нее ранее сохраненное
                //значение и перейдем на ячейку вперёд или назад, в зависимости от направления
                xpos = -1;
                noVal = true;
                arrayToRotate[newpos] = val;
                newpos += Integer.signum(rotateVal);
            }
            pos = newpos;
        }

        return  arrayToRotate;
    }

}
