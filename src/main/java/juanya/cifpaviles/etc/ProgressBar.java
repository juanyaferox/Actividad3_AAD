package juanya.cifpaviles.etc;

public class ProgressBar {
    private final int totalSteps;

    public ProgressBar(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public void simulateProcessing() {
        for (int i = 0; i <= totalSteps; i++) {
            updateProgressBar(i);
            simulateStep();
        }
        completeProgressBar();
    }

    private void updateProgressBar(int currentStep) {
        // Limpia la línea anterior en la consola
        System.out.print("\r");
        int percentage = (currentStep * 100) / totalSteps;
        String progressBar = buildProgressBar(percentage);
        System.out.print("Procesando: " + progressBar + " " + percentage + "%");
    }

    private void simulateStep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void completeProgressBar() {
        System.out.println();
    }

    private String buildProgressBar(int percentage) {
        int length = 50;
        int numberOfHashes = (percentage * length) / 100;
        int numberOfSpaces = length - numberOfHashes;

        StringBuilder progressBar = new StringBuilder("[");
        for (int i = 0; i < numberOfHashes; i++) {
            progressBar.append("#");
        }
        for (int i = 0; i < numberOfSpaces; i++) {
            progressBar.append(" ");
        }
        progressBar.append("]");

        return progressBar.toString();
    }

    public static void main(String[] args) {
        ProgressBar progressBar = new ProgressBar(100);
        progressBar.simulateProcessing();
    }
    }
