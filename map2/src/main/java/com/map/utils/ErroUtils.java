package com.map.utils;

import com.map.web.model.ResultBuilder;
import com.map.web.model.ResultModel;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: mengchen
 * Create by 18-4-11
 */
public class ErroUtils {
    public static ResultModel handlerReutrnError(BindingResult result) {
        List<String> errorList = new LinkedList<>();
        List<ObjectError> errors = result.getAllErrors();
        for (ObjectError objectError : errors) {
            FieldError fieldError = (FieldError) objectError;
            String message = fieldError.getField() + ":" + fieldError.getDefaultMessage();

            errorList.add(message);

        }
        return ResultBuilder.getFailure(-1, errorList);
    }
}
