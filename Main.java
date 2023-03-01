/* Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать получение всех детей выбранного человека. */

public class Main {
    public static void main(String[] args) {
        Person h1 = new Person("Kate", 47);
        Person h2 = new Person("Jake", 49);
        Person h3 = new Person("Alex", 23);
        Person h4 = new Person("Phil", 34);
        Person h5 = new Person("Christine", 32);
        Person h6 = new Person("Will", 10);
        Person h7 = new Person("Tommy", 7);

        GeoTree gt = new GeoTree();
        gt.appendParentChild(h1, h3); // Kate -> Alex
        gt.appendParentChild(h2, h3); // Jake -> Alex
        gt.appendSpouse(h1, h2); // Kate & Jake
        gt.appendParentChild(h4, h6); // Phil -> Will
        gt.appendParentChild(h4, h7); // Phil -> Tommy
        gt.appendParentChild(h5, h6); // Christine -> Will
        gt.appendParentChild(h5, h7); // Christine -> Tommy
        gt.appendSpouse(h4, h5); // Phil & Christine
        
        System.out.printf("Дети %s: ", h1.fullName);
        System.out.println(new Research(gt).spend(h1, Relationship.parent));
        System.out.printf("Дети %s: ", h4.fullName);
        System.out.println(new Research(gt).spend(h4, Relationship.parent));

        System.out.printf("%s женат/замужем за ", h5.fullName);
        System.out.println(new Research(gt).spend(h5, Relationship.husband));

        System.out.println(new Research(gt).searchAge());
    }
}