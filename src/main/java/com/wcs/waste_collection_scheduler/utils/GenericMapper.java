package com.wcs.waste_collection_scheduler.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GenericMapper {
    // Méthode pour mapper un objet source en un objet de type cible
    // ignoreProperties pour ignorer les propriétés que l'on veut ignorer
    public <S, T> T map(S source, Class<T> targetClass, String... ignoreProperties) {
        try {
            //création instance de l'objet cible
            T targetObject = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, targetObject, ignoreProperties);
            return targetObject;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping object", e);
        }
    }
}
