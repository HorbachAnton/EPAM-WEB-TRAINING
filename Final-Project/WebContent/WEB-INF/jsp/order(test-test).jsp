<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="utf-8">
						<title>Order</title>
					</head>
					<body>
						<c:set var="listMedicines" value="${sessionScope.order.getPurchasedMedications()}"/>
						<table>
							<c:forEach var="medicine" items="${listMedicines}">
								<tr>
									<td class="ID"><c:out value="${medicine.getId()}"/></td>
									<td class="Title"><c:out value="${medicine.getName()}"/></td>
									<td class="Type"><c:out value="${medicine.getType()}"/></td>
									<td class="Description"><c:out value="${medicine.getDescription()}"/></td>
									<td class="Dosage"><c:out value="${medicine.getDosage()}"/></td>
									<td class="Need_prescription">
										<c:if test="${medicine.isNeedPrescription()}">
											Отпускается по рецепту.
										</c:if>
										<c:if test="${!medicine.isNeedPrescription()}">
											Отпускается без рецепта.
										</c:if>
									</td>
									<td>
										<form action="contoller" method="post">
											<input type="hidden" name="command" value="deleted_ordered_medicine"/>
											<input type="hidden" name="deleted_medicine_id" value="${medicine.getId()}"/>
											<input type="submit" name="submit" value="Удалить из заказа"/>
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
					</body>
				</html>
