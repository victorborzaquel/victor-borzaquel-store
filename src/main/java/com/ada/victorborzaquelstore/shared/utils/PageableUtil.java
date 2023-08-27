package com.ada.victorborzaquelstore.shared.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public final class PageableUtil {
  public static final int DEFAULT_PAGE_NUMBER = 0;
  public static final int DEFAULT_PAGE_SIZE = 10;
  public static final int MAX_PAGE_SIZE = 100;

  private PageableUtil() {
  }

  public static Pageable getPageable(Pageable pageable) {
    if (pageable == null) {
      return PageRequest.of(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
    }

    return pageable;
  }
}
