# REST API - Authentication Endpoints

## Base URL

```
http://localhost:8080
```

---

## 1. Signup

**Endpoint:** `POST /api/auth/signup`

**Headers:**

| Key | Value |
|-----|-------|
| Content-Type | application/json |

**Request Body:**

```json
{
  "email": "john@example.com",
  "password": "secret123",
  "phone": "0771234567",
  "firstName": "John",
  "lastName": "Doe"
}
```

**Validation Rules:**

| Field | Rules |
|-------|-------|
| email | Required, valid email, max 80 characters |
| password | Required |
| phone | Required, max 15 characters |
| firstName | Required, max 50 characters |
| lastName | Required, max 50 characters |

**Success Response (200):**

```json
{
  "message": "User registered successfully"
}
```

**Error Responses:**

- `400` - Validation error (missing/invalid fields)
- `409` - Email or phone already in use

---

## 2. Signin

**Endpoint:** `POST /api/auth/signin`

**Headers:**

| Key | Value |
|-----|-------|
| Content-Type | application/json |

**Request Body:**

```json
{
  "email": "john@example.com",
  "password": "secret123"
}
```

**Validation Rules:**

| Field | Rules |
|-------|-------|
| email | Required, valid email, max 80 characters |
| password | Required |

**Success Response (200):**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "type": "Bearer",
  "email": "john@example.com",
  "role": "USER"
}
```

**Error Responses:**

- `400` - Validation error (missing/invalid fields)
- `401` - Invalid credentials

---

## 3. Profile (Protected)

**Endpoint:** `GET /api/auth/profile`

**Headers:**

| Key | Value |
|-----|-------|
| Authorization | Bearer {token} |

**Success Response (200):**

```json
{
  "publicId": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "email": "john@example.com",
  "role": "USER",
  "firstName": "John",
  "lastName": "Doe"
}
```

**Error Responses:**

- `401` - Missing or invalid token

---

## Postman Setup Steps

1. **Start the server:**
   ```bash
   ./mvnw spring-boot:run
   ```

2. **Signup first** to create a user account

3. **Signin** to get a JWT token from the response

4. **Access profile** by adding the token:
   - Go to **Authorization** tab
   - Select **Bearer Token** type
   - Paste the token from signin response

---

## Notes

- CSRF is disabled (stateless JWT authentication)
- JWT tokens expire after **24 hours**
- H2 Console available at `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:authdb`
  - Username: `hira`
  - Password: `1234`
