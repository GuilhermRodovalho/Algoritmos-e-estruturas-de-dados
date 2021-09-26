import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] openSites;          // keeps track of the openSites
    private final WeightedQuickUnionUF myUF;  
    private final int n;                      // Its the size of the Matrix that is trying to be percolated
    private int numberOfOpen;           // Keeps track of the number of openSites

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        int size = n*n+2; // posição 0 é a virtualização da parte de cima, e a posição n*n+1 é a virtualização da parte de baixo
        this.myUF = new WeightedQuickUnionUF(size);
        this.n = n;
        this.openSites = new boolean[n][n]; 
        this.numberOfOpen = 0;

        for (int i = 1; i <= n; i++) {
            myUF.union(0, i); // une as posições da parte de cima ao topo virtual
        }

        for (int i = (n*n-n)+1; i <= n*n; i++) {
            myUF.union(n*n+1, i); // une as posições de baixo à parte debaixo virtual
        }

    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > n || col > n || row < 1 || col < 1) throw new IllegalArgumentException();
        
        row = row - 1;
        col = col - 1; // o usuário quer acessar a coluna de 1 a n. Mas eu estou indexando de 0 a n-1

        if (myIsOpen(row - 1, col)) {
            myUF.union(ijTo1D(row, col), ijTo1D(row-1, col));
        } if (myIsOpen(row+1, col)) {
            myUF.union(ijTo1D(row, col), ijTo1D(row+1, col));
        } if (myIsOpen(row, col+1)) {
            myUF.union(ijTo1D(row, col), ijTo1D(row, col+1));
        } if (myIsOpen(row, col-1)) {
            myUF.union(ijTo1D(row, col), ijTo1D(row, col-1));
        }
        
        if (!openSites[row][col]) numberOfOpen++;
        openSites[row][col] = true;
    }

    private int ijTo1D(int row, int col) { // transforma a coordenada 2d em 1d (ex: matrix[2][1] vira array[7] para n = 3).
        return (row * n) + (col + 1);
    }

    private boolean myIsOpen(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) return false;

        return openSites[row][col];
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) throw new IllegalArgumentException();

        row--;
        col--;
        return openSites[row][col];
    }

    /**
     *
     * tem um bug no método is full, após o sistema Percolar (não sei se escreve assim), todos da linha de que estão abertos (e suas conexões), ficam como full. 
     *
     * Isso acontece porque todos da linha de baixo estão conectados ao ponto de baixo virtual.
     *
     * Soluções possíveis:
     * 1 - Criar uma nova {@link WeightedQuickUnionUF} apenas para resolver esse problema, logo ela não teria a conexão com com a parte de baixo virtual. 
     *
     *
     * @param row row at the Percolation system
     * @param col collumn at the Percolation systema
     * @return return true if the site is full
     */
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) throw new IllegalArgumentException();
        
        if (!isOpen(row, col)) return false;

        row--;
        col--;
        int pos = ijTo1D(row, col);

        int tmp = myUF.find(pos);
        int tmp2 = myUF.find(0);

        return tmp == tmp2;
        
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpen;
    }

    /**
     *    0
     *
     * 1  2  3
     *
     * 4  5  6
     *
     * 7  8  9
     * 
     *    10
     *
    */

    // does the system percolate?
    public boolean percolates() {
        int virtualTop = 0;
        int virtualBottom = n*n+1;

        if (n == 1) {
            if (isOpen(n, n)) {
                return true;
            }
            return false;
        }

        int tmp = myUF.find(virtualTop);
        int tmp2 = myUF.find(virtualBottom);

        return tmp == tmp2;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);

        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 1);

        System.out.println("Testes");
        System.out.println("Is full na posição 3, 1 (não deveria estar)");
        
        System.out.println(percolation.isFull(3, 1));

        System.out.println("Percolates (should be yes): " + percolation.percolates());

        System.out.println(percolation.numberOfOpenSites());
    }
}
