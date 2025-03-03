package br.com.uptech.utils;

import lombok.NoArgsConstructor;
import java.util.List;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public final class GenericConvertObjectUtils {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();

  public static <S, T> T convertObject(S sourceEntity, Class<T> targetDtoClass) {
    return MODEL_MAPPER.map(sourceEntity, targetDtoClass);
  }

  public static <S, T> List<T> convertObjectToList(List<S> sourceEntityList, Class<T> targetDtoClass) {
    return sourceEntityList.stream()
        .map(sourceEntity -> convertObject(sourceEntity, targetDtoClass)).toList();
  }

}