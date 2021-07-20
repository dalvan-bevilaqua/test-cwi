package com.cwi.testcwi.helper.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Translator {

  private final MessageSource messageSource;

  public String get(String message) {
    return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
  }

  public String get(String message, Object... args) {
    return messageSource.getMessage(message, args, LocaleContextHolder.getLocale());
  }

}
