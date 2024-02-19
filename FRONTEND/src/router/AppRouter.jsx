import { Home } from "../pages/Home/Home"
import { Lending } from "../pages/Lending/Lending"
import { LendingOk } from "../pages/Lending/LendingOk"
import { NewMember } from "../pages/NewMember/NewMember"
import { NewMemberOk } from "../pages/NewMember/NewMemberOk"
import { ReturnOk } from "../pages/ReturnOk/ReturnOk"
import { BrowserRouter, Route, Routes } from "react-router-dom";

export const AppRouter = () => {
  return (
    
    <BrowserRouter>
      <Routes>
        <Route path='/*' element={<Home />} />
        <Route path='/prestamo/:idBooks' element={<Lending />} />
        <Route path='/prestamo-ok/:idBooks' element={<LendingOk />} />
        <Route path='/nuevo-socio' element={<NewMember />} />
        <Route path='/nuevo-socio-ok/:idMembers' element={<NewMemberOk />} />
        <Route path='/devolucion-ok/:idBooks' element={<ReturnOk />} />
      </Routes>
    </BrowserRouter>
  )
}
