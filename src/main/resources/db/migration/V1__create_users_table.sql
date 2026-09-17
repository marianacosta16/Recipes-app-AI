-- Users: identity is the email itself (see UserId / Email in the domain model),
-- so there is no surrogate key column.

CREATE TABLE users (
    email   TEXT    NOT NULL,
    user_name VARCHAR(20) NOT NULL,

    CONSTRAINT users_pk PRIMARY KEY (email),

    CONSTRAINT users_email_lowercase    CHECK (email = lower(email)),
    CONSTRAINT users_email_has_at       CHECK (position('@' in email) > 1),
    CONSTRAINT users_email_not_blank    CHECK (btrim(email) <> ''),
    CONSTRAINT users_user_name_not_blank CHECK (btrim(user_name) <> ''),
    CONSTRAINT users_user_name_lowercase CHECK (user_name = lower(user_name))
);