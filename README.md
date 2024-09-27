# RPN Calculator And Minesweeper

This project contains two main components: an RPN (Reverse Polish Notation) Calculator and a Minesweeper game solver.

## RPN Calculator

The RPN Calculator allows you to perform calculations using Reverse Polish Notation.

### API Endpoint

- **URL**: `http://localhost:8080/api/calculate`
- **Method**: POST

### Request Format

```json
{
  "expression": "20 5 /"
}
```

### Response Format

```json
{
  "result": 4.0
}
```

## Minesweeper Solver

The Minesweeper solver takes a minefield configuration and returns a grid with hints about neighboring mines.

### API Endpoint

- **URL**: `http://localhost:8080/api/show-hints`
- **Method**: POST

### Request Format

```json
{
  "square": [
    "**...",
    ".....",
    ".*..."
  ]
}
```

### Response Format

```json
{
  "hints": [
    "**100",
    "33200",
    "1*100"
  ]
}
```

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/sedatbali44/rpn-minesweeper.git
   ```

2. Navigate to the project directory:
   ```
   cd rpn-minesweeper
   ```


3. The server will start on `localhost:8080`. You can now use the API endpoints as described above.

## Technologies Used

- Java
- Spring Boot
- Maven
- Postman
