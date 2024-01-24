package juanya.cifpaviles.etc;

public class ProgressBar {
    private final int totalSteps;
    private int currentStep;

    public ProgressBar(int totalSteps) {
        this.totalSteps = totalSteps;
        this.currentStep = 0;
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

        // Calcula el porcentaje completado
        int percentage = (currentStep * 100) / totalSteps;

        // Construye la cadena de la barra de carga
        String progressBar = buildProgressBar(percentage);

        // Imprime la barra de carga en la consola
        System.out.print("Procesando: " + progressBar + " " + percentage + "%");
    }

    private void simulateStep() {
        try {
            // Simula un paso en el procesamiento
            Thread.sleep(10); // Reducido el tiempo de espera a 10 milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        currentStep++;
    }

    private void completeProgressBar() {
        // Imprime una nueva línea para separar la barra de carga de cualquier salida posterior
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
