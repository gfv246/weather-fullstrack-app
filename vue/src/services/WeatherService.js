import axios from 'axios';

const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
    getWeather(zipcode){
        return http.get(`/weather?zip=${zipcode}`);
    }
}