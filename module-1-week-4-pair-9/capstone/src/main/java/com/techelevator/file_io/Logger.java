package com.techelevator.file_io;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger
{
    private static final String FILE_EXTENSION = ".log";

    private String directory;

    public Logger(String directory)
    {
        this.directory = directory;
    }


    public void logMessage(String message)
    {
        String fileName = LocalDate.now().format(DateTimeFormatter.ISO_DATE); //YYYY-MM-DD
        String logFilePath = directory + "/" + fileName + FILE_EXTENSION;
        File logFile = new File(logFilePath);
        logFile.getParentFile().mkdirs();

        try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))){
            log.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " + LocalTime.now() + " " + message);

        } catch (IOException ex) {
            System.out.println("File can not be created");
        }
    }

    public void logSalesReport()
    {
        String fileName = "sales_report";
        String logFilePath = directory + "/" + fileName + FILE_EXTENSION;
        File logFile = new File(logFilePath);
        logFile.getParentFile().mkdirs();
    }


}
