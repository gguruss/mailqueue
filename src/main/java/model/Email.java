package model;

import constants.EmailType;
import java.io.Serializable;

public class Email implements Serializable {

  private String sender;

  private String receiver;

  private EmailType emailType;

  public static class Builder {

    private String sender;

    private String receiver;

    private EmailType emailType;

    public Builder setSender(final String sender) {
      this.sender = sender;
      return this;
    }

    public Builder setReceiver(final String receiver) {
      this.receiver = receiver;
      return this;
    }

    public Builder setEmailType(final EmailType emailType) {
      this.emailType = emailType;
      return this;
    }

    public Email build() {
      return new Email(this);
    }

  }

  public Email(Builder builder) {
    this.sender = builder.sender;
    this.receiver = builder.receiver;
    this.emailType = builder.emailType;
  }

  @Override
  public String toString() {
    return "Email{" +
        "sender='" + sender + '\'' +
        ", receiver='" + receiver + '\'' +
        ", emailType=" + emailType +
        '}';
  }

  public String getSender() {
    return sender;
  }

  public String getReceiver() {
    return receiver;
  }

  public EmailType getEmailType() {
    return emailType;
  }
}
