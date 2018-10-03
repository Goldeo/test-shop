package ru.test_shop.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException
public class ArgumentException extends TestShopException {
  private static final long serialVersionUID = 5680878665665417133L;

  public ArgumentException(String message) {
    super(message);
  }

  public ArgumentException(String message, Throwable cause) {
    super(message, cause);
  }

  public ArgumentException(Throwable cause) {
    super(cause);
  }
}

