package ru.test_shop.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class NotFoundException extends TestShopException {
  private static final long serialVersionUID = 722104037440763637L;

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }
}

