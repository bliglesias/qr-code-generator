# QR Code Generator

A simple web application that generates QR codes from text or URLs. Built with Java Spring Boot and containerized with Docker.

## What I Learned

This was a learning project where I:
- Built a REST API with Spring Boot
- Used the ZXing library for QR code generation
- Created a simple HTML/CSS/JavaScript frontend
- Containerized the application with Docker
- Understood Maven dependency management

## Technologies Used

- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Web framework
- **ZXing** - QR code generation library
- **Docker** - Containerization
- **Maven** - Dependency management

## How to Run

### Option 1: With Docker (Recommended)
```bash
docker build -t qr-code-generator .
docker run -p 8080:8080 qr-code-generator
```

Then open: http://localhost:8080

### Option 2: With Maven
```bash
mvn spring-boot:run
```

## API Endpoint

`GET /api/qr/generate?text={your-text}&size={size}`

Example: `http://localhost:8080/api/qr/generate?text=HelloWorld&size=300`

## Project Structure
```
src/
├── main/
│   ├── java/com/brandon/
│   │   ├── QrCodeApplication.java    # Main Spring Boot application
│   │   └── QrCodeController.java     # REST API controller
│   └── resources/
│       └── static/
│           └── index.html            # Web interface
├── Dockerfile                         # Docker configuration
└── pom.xml                           # Maven dependencies
```

## Future Improvements

- [ ] Add QR code color customization
- [ ] Implement QR code download feature
- [ ] Add history of generated QR codes
- [ ] Deploy to cloud platform

## Author

[Brandon Iglesias] - Learning Spring Boot and Docker