package com.skobeev.util;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateModel {

    private Validator validator=new Validator();

    public Map<String, List<String>> validateModel(Object object) {


        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<ConstraintViolation> violations = validator.validate(object);
        for (ConstraintViolation obj : violations) {
            String key = ((FieldContext) obj.getContext()).getField().getName();
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                list.add(obj.getMessage());
            } else {
                list.add(obj.getMessage());
            }
            map.put(key, list);
        }
        return map;
    }
}
