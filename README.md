<h1>Brazil Business Toolkit API</h1>

A comprehensive REST API for Brazilian business calculations and validations. Perfect for fintech, HR systems, and accounting software.
Features

<h2><br>✅ Validators</br></h2>

<h3>CPF Validation </h3>
<ul>
  <li>Validates and formats Brazilian CPF numbers</li>
</ul>

CNPJ Validation 
<ul>

  <li>Validates and formats Brazilian CNPJ numbers</li>
</ul>
💰 Financial Calculators

FGTS Calculator - Calculate FGTS deposits and balance
13th Salary Calculator - Calculate 13º salário with installments

Tech Stack

Java 17
Spring Boot 3.2
Maven
No database required (100% stateless)

Getting Started
Prerequisites

JDK 17 or higher
Maven 3.6+

Installation

Clone the repository

bashgit clone <your-repo-url>
cd brazil-business-api

Build the project

bashmvn clean install

Run the application

bashmvn spring-boot:run
The API will be available at http://localhost:8080
API Endpoints
Validators
Validate CPF
bashGET /api/v1/validate/cpf/{cpf}

# Example
curl http://localhost:8080/api/v1/validate/cpf/12345678909

# Response
{
  "type": "CPF",
  "input": "12345678909",
  "valid": true,
  "formatted": "123.456.789-09",
  "message": "CPF válido"
}
Validate CNPJ
bashGET /api/v1/validate/cnpj/{cnpj}

# Example
curl http://localhost:8080/api/v1/validate/cnpj/11222333000181

# Response
{
  "type": "CNPJ",
  "input": "11222333000181",
  "valid": true,
  "formatted": "11.222.333/0001-81",
  "message": "CNPJ válido"
}
Financial Calculators
Calculate FGTS
bashPOST /api/v1/calculate/fgts
Content-Type: application/json

{
  "monthlySalary": 5000.00,
  "monthsWorked": 24
}

# Response
{
  "monthlySalary": 5000.00,
  "monthsWorked": 24,
  "monthlyFgtsDeposit": 400.00,
  "totalFgtsBalance": 9600.00,
  "fgtsRate": "8%"
}
