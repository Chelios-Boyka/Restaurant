import { useEffect, useState } from "react";
import React from "react";
import { bookingList } from "../services/BookingService";

const BookingList = () => {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    bookingList()
      .then((response) => {
        setBookings(response.data);
      })
      .catch((error) => console.error(error));
  }, []);
  /*const dataD = [
    {
      id: 1,
      firstName: "AL",
      lastName: "Iturr",
      email: "as@mail.com",
    },
    {
      id: 2,
      firstName: "CanMon",
      lastName: "Iturr",
      email: "jlo@mail.com",
    },
    {
      id: 3,
      firstName: "CHIKI",
      lastName: "Iturr",
      email: "ak@mail.com",
    },
  ];*/
  return (
    <div className="container">
      <div className="center">
        <h2 className="text-center text-light">Booking List</h2>
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th className="bg-danger">Reservation id</th>
              <th>Table spots</th>

              <th className="bg-danger">First Name</th>
              <th>Last Name</th>
              <th className="bg-danger">Email</th>
              <th>Booked At</th>
            </tr>
          </thead>
          <tbody>
            {bookings.map((book) => (
              <tr key={book.id}>
                <td>{book.id}</td>
                <td className="table-danger">{book.tableSize} chairs</td>
                <td>{book.firstName}</td>
                <td className="table-danger">{book.lastName}</td>
                <td>{book.email}</td>
                <td className="table-danger">{book.bookedAt}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default BookingList;
