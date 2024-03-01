import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8086/restaurant/bookings";

export const bookingList = () => axios.get(REST_API_BASE_URL);
