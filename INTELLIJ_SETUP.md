# IntelliJ IDEA Setup Guide

This project has been configured to work with IntelliJ IDEA.

## Opening the Project

1. Open IntelliJ IDEA
2. Select "Open" or "File" → "Open"
3. Navigate to this directory and select it
4. IntelliJ will automatically detect the project structure

## Project Configuration

- **Main Class**: `Start`
- **Source Directory**: `src/`
- **Output Directory**: `out/` (will be created automatically)
- **Java Version**: 1.8

## Dependencies

The following libraries are configured:
- `mysql-connector-j-9.4.0.jar` (located in `dist/lib/`)
- `AbsoluteLayout.jar` (located in `dist/lib/`)

## Running the Project

1. Open the "Run" menu or use the toolbar
2. Select the "Start" run configuration
3. Click the Run button (or press Shift+F10)

Alternatively:
- Right-click on `Start.java` in the project tree
- Select "Run 'Start.main()'"

## Important Notes

- Resources (images) are located in `src/` and `src/image/` directories
- The project uses NetBeans AbsoluteLayout library for GUI layout
- Database connection settings are in `src/project/ConnectionProvider.java`
- Make sure MySQL is running and the database `hotel` exists before running

## Troubleshooting

If you encounter issues:

1. **JDK not found**: Go to File → Project Structure → Project, and set the Project SDK to Java 1.8 or higher
2. **Libraries not found**: Go to File → Project Structure → Libraries, and verify both JAR files are listed
3. **Resources not loading**: Make sure `src/` is marked as a source folder (it should be automatic)
4. **Compilation errors**: Try File → Invalidate Caches / Restart

