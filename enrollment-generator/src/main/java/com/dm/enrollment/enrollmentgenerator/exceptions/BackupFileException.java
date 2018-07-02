/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dm.enrollment.enrollmentgenerator.exceptions;

/**
 *
 * @author danimaetrix
 */
public class BackupFileException extends Exception {


        public BackupFileException(String message) {
            super(message);
        }

        public BackupFileException(String message, Throwable cause) {
            super(message, cause);
        }   

}
