import { useState } from "react";
import "./FormMembers.css";
import { useDataMembers } from "../../context/DataMembers";

export const FormMembers = () => {
  const { postMembers } = useDataMembers();
  const [newMember, setNewMember] = useState({
    name: "",
    lastName: "",  
    phone: "",
    email: "",
  });

  const handleNewMember = () => {
    postMembers(newMember);
    setNewMember({
      name: "",
      lastNames: "",  // Cambiado de 'lastname' a 'lastNames'
      phone: "",
      email: "",
    });
  };

  return (
    <div className="Form">
      <h2 className="Form__title">Crear nuevo usuario</h2>
      <form className="formContainer">
        <section className="formContainer__up">
          <label htmlFor="formName">NOMBRE</label>
          <input
            className="formContainer__input-name"
            type="text"
            id="formName"
            name="name"
            placeholder="Nombre"
            required
          />

          <label htmlFor="formLastname">APELLIDOS</label>
          <input
            className="formContainer__input-Lastname"
            type="text"
            id="formLastname"
            name="lastName"  
            placeholder="Apellidos"
            required
          />
        </section>

        <section className="formContainer__down">
          <div>
            <label htmlFor="formPhone">TELÉFONO</label>
            <input
              className="formContainer__input-phone"
              type="tel"
              id="formPhone"
              name="phone"
              placeholder="63352..."
              required
            />
          </div>
          <div>
            <label htmlFor="formEmail">CORREO ELECTRÓNICO</label>
            <input
              className="formContainer__input-email"
              type="email"
              id="formEmail"
              name="email"
              placeholder="correo@correo.es"
              required
            />
          </div>
        </section>

        <button
          className="formContainer__button"
          type="button"
          onClick={handleNewMember}
        >
          Añadir Socio
        </button>
      </form>
    </div>
  );
};
