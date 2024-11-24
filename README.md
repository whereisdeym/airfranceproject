1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/airfrense.git
   cd airfrense
   ```


Example cURL Requests
Here is a collection of example requests to test the application.

1. Add a Ticket Type
```bash
curl -X POST http://localhost:8080/ticket-types \
     -H "Content-Type: application/json" \
     -d '{
           "name": "Economy Class",
           "description": "Basic seating with limited amenities"
         }'
```

2. List All Ticket Types
```bash
curl -X GET http://localhost:8080/ticket-types
```

3. Add a Service
```bash
curl -X POST http://localhost:8080/services \
     -H "Content-Type: application/json" \
     -d '{
           "name": "Wi-Fi",
           "description": "In-flight Wi-Fi access"
         }'
```

4. Link a Service to a Ticket Type
Replace {TICKET_TYPE_ID} and {SERVICE_ID} with the UUIDs obtained from the responses of previous requests.
```bash
curl -X PATCH http://localhost:8080/ticket-types/{TICKET_TYPE_ID}/add-service/{SERVICE_ID}
```

5. Create a Reservation
Replace {TICKET_TYPE_ID} with the UUID of a ticket type.
```bash
curl -X POST http://localhost:8080/reservations \
     -H "Content-Type: application/json" \
     -d '{
           "passengerName": "John Doe",
           "departureDateTime": "2024-12-01T10:00:00",
           "departureCity": "New York",
           "arrivalCity": "London",
           "ticketType": {
               "id": "{TICKET_TYPE_ID}"
           }
         }'
```

6. List All Reservations
```bash
curl -X GET http://localhost:8080/reservations
```

7. Update a Reservation
Replace {RESERVATION_ID} with the UUID of the reservation and {TICKET_TYPE_ID} with the ticket type UUID.
```bash
curl -X PUT http://localhost:8080/reservations/{RESERVATION_ID} \
     -H "Content-Type: application/json" \
     -d '{
           "passengerName": "Jane Doe",
           "departureDateTime": "2024-12-05T15:00:00",
           "departureCity": "Paris",
           "arrivalCity": "Tokyo",
           "ticketType": {
               "id": "{TICKET_TYPE_ID}"
           }
         }'
```

8. Delete a Reservation
Replace {RESERVATION_ID} with the UUID of the reservation.
```bash
curl -X DELETE http://localhost:8080/reservations/{RESERVATION_ID}
```
