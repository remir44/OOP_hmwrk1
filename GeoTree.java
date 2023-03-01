import java.util.ArrayList;

public class GeoTree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    // связь родитель - ребенок
    public void appendParentChild(Person parent, Person child) {
        tree.add(new Node(parent, Relationship.parent, child));
        tree.add(new Node(child, Relationship.child, parent));
    }

    // связь муж - жена
    public void appendSpouse(Person wife, Person husband) {
        tree.add(new Node(wife, Relationship.wife, husband));
        tree.add(new Node(husband, Relationship.husband, wife));
    }
}
