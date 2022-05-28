package zadanie_4_2;

public class AutoShop {

    public static void main(String[] args) {

        Sedan sedan = new Sedan(120, 3000, "Niebieski", 6);
        Ford ford = new Ford(150, 30000, "Zielony", 2022, 0);
        Ford ford2 = new Ford(140, 30000, "Biały", 2021, 500);
        Truck truck = new Truck(100, 500000, "Czarny", 2500);


        System.out.println(sedan.getPurchaseInfo() + " : " + sedan.getSalePrice());
        System.out.println(ford.getPurchaseInfo() + " : " + ford.getSalePrice());
        System.out.println(ford2.getPurchaseInfo() + " : " + ford2.getSalePrice());
        System.out.println(truck.getPurchaseInfo() + " : " + truck.getSalePrice());
    }
}