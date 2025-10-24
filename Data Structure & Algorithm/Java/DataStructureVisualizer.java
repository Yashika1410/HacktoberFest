import java.util.*;

public class DataStructureVisualizer {
    private static class BSTNode {
        int val;
        BSTNode left, right;
        int height;
        
        BSTNode(int val) {
            this.val = val;
            this.height = 1;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTNode root = null;
        Random random = new Random();
        
        System.out.println("🌳 Self-Balancing BST Visualizer");
        
        while (true) {
            System.out.println("\n1. Insert Random Value");
            System.out.println("2. Delete Random Value");
            System.out.println("3. Display Tree");
            System.out.println("4. Performance Analysis");
            System.out.println("5. Exit");
            System.out.print("Choose operation: ");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    int insertVal = random.nextInt(100);
                    root = insert(root, insertVal);
                    System.out.println("Inserted: " + insertVal);
                    break;
                case 2:
                    if (root != null) {
                        int deleteVal = getRandomValue(root, random);
                        root = delete(root, deleteVal);
                        System.out.println("Deleted: " + deleteVal);
                    }
                    break;
                case 3:
                    displayTree(root);
                    break;
                case 4:
                    analyzePerformance(root);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static BSTNode insert(BSTNode node, int val) {
        if (node == null) return new BSTNode(val);
        
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else {
            return node; // No duplicates
        }
        
        return balance(node);
    }
    
    private static BSTNode delete(BSTNode node, int val) {
        if (node == null) return null;
        
        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                BSTNode minNode = findMin(node.right);
                node.val = minNode.val;
                node.right = delete(node.right, minNode.val);
            }
        }
        
        return (node != null) ? balance(node) : null;
    }
    
    private static BSTNode balance(BSTNode node) {
        updateHeight(node);
        int balance = getBalance(node);
        
        // Left Heavy
        if (balance > 1) {
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        
        // Right Heavy
        if (balance < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        
        return node;
    }
    
    private static BSTNode rotateRight(BSTNode y) {
        BSTNode x = y.left;
        BSTNode T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        updateHeight(y);
        updateHeight(x);
        
        return x;
    }
    
    private static BSTNode rotateLeft(BSTNode x) {
        BSTNode y = x.right;
        BSTNode T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        updateHeight(x);
        updateHeight(y);
        
        return y;
    }
    
    private static void updateHeight(BSTNode node) {
        if (node != null) {
            node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
    
    private static int getHeight(BSTNode node) {
        return (node == null) ? 0 : node.height;
    }
    
    private static int getBalance(BSTNode node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }
    
    private static BSTNode findMin(BSTNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
    
    private static int getRandomValue(BSTNode root, Random random) {
        List<Integer> values = new ArrayList<>();
        collectValues(root, values);
        return values.get(random.nextInt(values.size()));
    }
    
    private static void collectValues(BSTNode node, List<Integer> values) {
        if (node != null) {
            collectValues(node.left, values);
            values.add(node.val);
            collectValues(node.right, values);
        }
    }
    
    private static void displayTree(BSTNode root) {
        System.out.println("\n🌳 Tree Structure:");
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        
        printTree(root, "", true);
        System.out.println("Root: " + root.val + " | Height: " + root.height);
    }
    
    private static void printTree(BSTNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val + 
                             " [H:" + node.height + " B:" + getBalance(node) + "]");
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
    
    private static void analyzePerformance(BSTNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
        int height = root.height;
        int size = countNodes(root);
        double optimalHeight = Math.log(size + 1) / Math.log(2);
        
        System.out.println("\n📊 Performance Analysis:");
        System.out.println("Tree size: " + size + " nodes");
        System.out.println("Current height: " + height);
        System.out.printf("Optimal height: %.2f\n", optimalHeight);
        System.out.println("Balance efficiency: " + 
            (height <= optimalHeight * 1.5 ? "✅ Excellent" : "⚠️  Needs rebalancing"));
        System.out.println("Tree type: " + 
            (Math.abs(getBalance(root)) <= 1 ? "Balanced" : "Unbalanced"));
    }
    
    private static int countNodes(BSTNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
