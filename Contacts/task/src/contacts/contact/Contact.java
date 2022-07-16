package contacts.contact;

import contacts.validator.PhoneNumberValidator;

import java.time.LocalDateTime;

public abstract class Contact {
    protected String name;
    protected String number;
    protected final LocalDateTime created;
    protected LocalDateTime lastEdit;

    protected Contact() {
        lastEdit = created = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = PhoneNumberValidator.validateAndReturn(number);
    }

    public abstract void edit();

    protected abstract boolean isInvalidField(String field);

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public abstract String getInfo();
}
