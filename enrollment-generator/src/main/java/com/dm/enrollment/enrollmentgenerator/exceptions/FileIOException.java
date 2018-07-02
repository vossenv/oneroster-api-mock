/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dm.enrollment.enrollmentgenerator.exceptions;

/**
 *
 * @author Danimaetrix
 */
public class FileIOException extends Exception {

    public FileIOException(String message) {
        super(message);
    }

    public FileIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
