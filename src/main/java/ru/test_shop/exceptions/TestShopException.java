package ru.test_shop.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class TestShopException extends RuntimeException {
  private static final long serialVersionUID = -177346873953265026L;

  public TestShopException(String message) {
    super(message);
  }

  public TestShopException(String message, Throwable cause) {
    super(message, cause);
  }

  public TestShopException(Throwable cause) {
    super(cause);
  }
}
