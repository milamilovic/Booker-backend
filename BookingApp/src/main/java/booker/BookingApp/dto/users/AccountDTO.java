package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Account;
import lombok.Data;

public @Data class AccountDTO {
    private Long id;

    //private Long userId;
    private Role role;
    private boolean blocked;
    private boolean deleted;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this(account.getId(), account.getRole(), account.isBlocked(), account.isDeleted());
    }

    public AccountDTO(Long id, Role role, boolean blocked, boolean deleted) {
        this.id = id;
        this.role = role;
        this.blocked = blocked;
        this.deleted = deleted;
    }
}
