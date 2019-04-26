package task03;

public class FirstThread extends Thread {
    private Product product;

    public FirstThread(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (product){
                while (!product.isConsumed()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);

                    }
                }
                product.produce();
            }
        }
    }
}
