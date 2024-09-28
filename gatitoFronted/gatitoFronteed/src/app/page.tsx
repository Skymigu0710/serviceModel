"use client";
import axios from "axios";
import { RSCPathnameNormalizer } from "next/dist/server/future/normalizers/request/rsc";
import React, { useEffect, useState } from "react";

const baseURL = "http://localhost:8080/api/v1/gatito";

export default function Home() {
  const [gatito, setGatito] = useState([]);
  const [newgatito, setNewGatito] = useState({
    id: "",
    name: "",
    raza: "",
    color: "",
    dueño: ""
  });

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      setGatito(response.data);
    });
  }, []);

  const handleAddGatito = () => {
    axios.post(baseURL, newgatito).then((response) => {
      setGatito([...gatito, response.data]);
      setNewGatito({
        id: "",
        name: "",
        raza: "",
        color: "",
        dueño: ""
      });
    });
  };
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setNewGatito({ ...newgatito, [name]: value });
  };

  return (
    <div className="container mx-auto ">
      <header className="py-1">
        <nav className="bg-black py-2 rounded-xl my-2 ">
          <ul className="flex flex-row justify-center gap-6 flex">
            <li className="text-white">Show</li>
            <li className="text-white">Add</li>
            <li className="text-white">Delete</li>
            <li className="text-white">Gatitos</li>
            <li className="text-white">Dueño</li>
          </ul>
        </nav>
      </header>
      <h1 className="px-2">GATITOS</h1>
      <div className="flex flex-col gap-2 px-2">
        
        <p className="">Raza:
          <input name="raza"
            value={newgatito.raza}
            onChange={handleChange} className="bg-pink-300 px-3 rounded-xl">
          </input></p>
        <p className="">Gatito Name:
          <input name="name"
            value={newgatito.name}
            onChange={handleChange}
            className="bg-pink-300 px-3 rounded-xl">
          </input></p>
        <p className="">Color:
          <input name="color"
            value={newgatito.color}
            onChange={handleChange} className="bg-pink-300 px-3 rounded-xl">
          </input></p>
        <p className="">Dueño:
          <input name="dueño"
            value={newgatito.dueño}
            onChange={handleChange} className="bg-pink-300 px-3 rounded-xl">
          </input></p>
        <button className="bg-pink-500 text-white px-4 py-2 rounded-lg hover:bg-pink-700" onClick={handleAddGatito}  >
          Add
        </button>
      </div>
      {gatito &&
        gatito.length > 0 &&
        gatito.map((gato: any) => (
          <div key={gato.id} className="my-4 bg-black rounded-2xl p-2">
            <p className="text-white">Gatito ID: {gato.id}</p>
            <p className="text-white">Gatito Name: {gato.name}</p>
            <p className="text-white">Raza: {gato.raza}</p>
            <p className="text-white">Color: {gato.color}</p>
            <p className="text-white">Dueño: {gato.dueño}</p>
          </div>
        ))}
    </div>
  );
}