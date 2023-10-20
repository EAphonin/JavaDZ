package seminar6.hw;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<NoteBook> noteBooks = new HashSet<>();

        noteBooks.add(new NoteBook("Asus", 16, 1024, "Windows", "Grey"));
        noteBooks.add(new NoteBook("Acer", 32, 2048, "No OS", "Black"));
        noteBooks.add(new NoteBook("Apple", 32, 512, "MacOS", "Grey"));
        noteBooks.add(new NoteBook("Samsung", 8, 512, "Windows", "White"));
        noteBooks.add(new NoteBook("Samsungtest", 8, 2048, "Windows", "White"));
        noteBooks.add(new NoteBook("HP", 16, 512, "Linux", "Red"));


        filterNoteBooks(noteBooks);
    }

    public static void filterNoteBooks(Set<NoteBook> noteBooks) {
        Map<Integer, String> parameters = new HashMap<>();
        parameters.put(1, "Ram");
        parameters.put(2, "Hdd");
        parameters.put(3, "Os");
        parameters.put(4, "Color");
        parameters.put(5, "Search");

        Map<Integer, String> os = new HashMap<>();
        os.put(1, "Windows");
        os.put(2, "MacOS");
        os.put(3, "Linux");
        os.put(4, "No OS");

        Map<Integer, String> color = new HashMap<>();
        color.put(1, "Grey");
        color.put(2, "Black");
        color.put(3, "White");
        color.put(4, "Red");

        int minRam = 1;
        int minHdd = 1;
        String inputOs = "0";
        String inputColor = "0";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберете необходимый параметр: ");
            System.out.println("1 - Объем оперативной памяти");
            System.out.println("2 - Объем жесткого диска");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Поиск");
            Integer inputUser = scanner.nextInt();

            if (!parameters.containsKey(inputUser)) {
                System.out.println("Вы указали неверный параметр, выберете из списка. ");
            } else {
                String selectedParams = parameters.get(inputUser);
                switch (selectedParams) {
                    case "Ram":
                        System.out.print("Доступные объемы памяти: 8GB, 16GB, 32GB" + '\n'
                                + "Введите минимальный объем: ");
                        minRam = scanner.nextInt();
                        if (minRam < 8 || minRam > 32) {
                            System.out.println("Введите объем памяти из доступных.");
                        } else {
                            System.out.println("Параметр учтен.");
                        }
                        break;
                    case "Hdd":
                        System.out.print("Доступные объемы ЖД: 512GB, 1024GB, 2048GB" + '\n'
                                + "Введите минимальный объем: ");
                        minHdd = scanner.nextInt();
                        if (minHdd < 512 || minHdd > 2048) {
                            System.out.println("Введите размер диска из доступных.");
                        } else {
                            System.out.println("Параметр учтен.");
                        }
                        break;
                    case "Os":
                        System.out.print("Доступные ОС: 1 - Windows, 2 - MacOS, 3 - Linux,4 - No OS " + '\n'
                                + "Введите предпочитаемую ОС: ");
                        Integer indexOS = scanner.nextInt();
                        if (indexOS < 1 || indexOS > 4) {
                            System.out.println("Выберете ОС из доступных.");
                        } else {
                            inputOs = os.get(indexOS);
                            System.out.println("Параметр учтен.");
                        }
                        break;
                    case "Color":
                        System.out.print("Доступные цвета: 1- Grey, 2 - Black,3 - White,4- Red" + '\n'
                                + "Введите желаемый цвет: ");
                        Integer indexColor = scanner.nextInt();
                        if (indexColor < 1 || indexColor > 4) {
                            System.out.println("Выберете ОС из доступных.");
                        } else {
                            inputColor = color.get(indexColor);
                            System.out.println("Параметр учтен.");
                        }
                        break;
                    case "Search":
                        for (NoteBook nb : noteBooks) {
                            if (minRam <= nb.getRam() && minHdd <= nb.getHdd()
                                    && (inputOs.equals("0") || nb.getOs().equalsIgnoreCase(inputOs))
                                    && (inputColor.equals("0") || nb.getColor().equalsIgnoreCase(inputColor))) {
                                System.out.println(nb);
                            }
                        }
                        scanner.close();
                        return;
                }
            }
        }
    }
}

