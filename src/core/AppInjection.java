package core;

import controller.*;

/**
 * Central dependency injection container that manages and provides access to application controllers.
 * This class follows the singleton pattern for controller instances, ensuring they are initialized
 * once when the class is loaded and reused throughout the application.
 * 
 * <p>Usage example:
 * <pre>
 * TaskController taskController = AppInjection.getTaskController();
 * LabelsController labelsController = AppInjection.getLabelsController();
 * </pre>
 * 
 * @see controller.TaskController
 * @see controller.ClickController
 * @see controller.LabelsController
 */
public class AppInjection {
    
    private static TaskController taskController;
    private static ClickController clickController;
    private static LabelsController labelsController;
    
    static {
        initialize();
    }
    
    /**
     * Initializes all controller instances. This method is automatically called
     * when the class is loaded due to the static initialization block.
     * 
     * <p>Initialization order:
     * <ol>
     *   <li>TaskController</li>
     *   <li>ClickController</li>
     *   <li>LabelsController</li>
     * </ol>
     */
    public static void initialize() {
        taskController = new TaskController();
        clickController = new ClickController();
        labelsController = new LabelsController();
    }
    
    /**
     * Returns the singleton instance of TaskController.
     * 
     * @return the shared TaskController instance
     * @throws IllegalStateException if the controller has not been initialized
     */
    public static TaskController getTaskController() {
        if (taskController == null) {
            throw new IllegalStateException("TaskController not initialized");
        }
        return taskController;
    }
    
    /**
     * Returns the singleton instance of ClickController.
     * 
     * @return the shared ClickController instance
     * @throws IllegalStateException if the controller has not been initialized
     */
    public static ClickController getClickController() {
        if (clickController == null) {
            throw new IllegalStateException("ClickController not initialized");
        }
        return clickController;
    }

    /**
     * Returns the singleton instance of LabelsController.
     * 
     * @return the shared LabelsController instance
     * @throws IllegalStateException if the controller has not been initialized
     */
    public static LabelsController getLabelsController() {
        if (labelsController == null) {
            throw new IllegalStateException("LabelsController not initialized");
        }
        return labelsController;
    }
}