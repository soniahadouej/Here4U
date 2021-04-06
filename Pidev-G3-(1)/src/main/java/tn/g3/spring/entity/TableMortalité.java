package tn.g3.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_mortalite")
public class TableMortalité  implements Serializable{
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="IdTable")
		private Long idTable ;

		
		//@Column(name="TD 99")
		private float lx_h;

		//@Column(name="TV 99")
		private float lx_f;
		
		private float dx_h;
		private float dx_f;
		private float px_h;
		private float px_f;
		public Long getIdTable() {
			return idTable;
		}
		public void setIdTable(Long idTable) {
			this.idTable = idTable; }
	 
		public float getLx_h() {
			return lx_h;
		}
		public void setLx_h(float lx_h) {
			this.lx_h = lx_h;
		}
		public float getLx_f() {
			return lx_f;
		}
		public void setLx_f(float lx_f) {
			this.lx_f = lx_f;
		}
		public float getDx_h() {
			return dx_h;
		}
		public void setDx_h(float dx_h) {
			this.dx_h = dx_h;
		}
		public float getDx_f() {
			return dx_f;
		}
		public void setDx_f(float dx_f) {
			this.dx_f = dx_f;
		}
		public float getPx_h() {
			return px_h;
		}
		public void setPx_h(float px_h) {
			this.px_h = px_h;
		}
		public float getPx_f() {
			return px_f;
		}
		public void setPx_f(float px_f) {
			this.px_f = px_f;
		}
		public TableMortalité(Long idTable, float lx_h, float lx_f, float dx_h, float dx_f, float px_h,
				float px_f) {
			super();
			this.idTable = idTable;
			this.lx_h = lx_h;
			this.lx_f = lx_f;
			this.dx_h = dx_h;
			this.dx_f = dx_f;
			this.px_h = px_h;
			this.px_f = px_f;
		}
		public TableMortalité(float lx_h, float lx_f, float dx_h, float dx_f, float px_h, float px_f) {
			super();
			this.lx_h = lx_h;
			this.lx_f = lx_f;
			this.dx_h = dx_h;
			this.dx_f = dx_f;
			this.px_h = px_h;
			this.px_f = px_f;
		}
		public TableMortalité() {
			super();
		}
		@Override
		public String toString() {
			return "TableMortalité [idTable=" + idTable + ", lx_h=" + lx_h + ", lx_f=" + lx_f + ", dx_h=" + dx_h
					+ ", dx_f=" + dx_f + ", px_h=" + px_h + ", px_f=" + px_f + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(dx_f);
			result = prime * result + Float.floatToIntBits(dx_h);
			result = prime * result + ((idTable == null) ? 0 : idTable.hashCode());
			result = prime * result + Float.floatToIntBits(lx_f);
			result = prime * result + Float.floatToIntBits(lx_h);
			result = prime * result + Float.floatToIntBits(px_f);
			result = prime * result + Float.floatToIntBits(px_h);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TableMortalité other = (TableMortalité) obj;
			if (Float.floatToIntBits(dx_f) != Float.floatToIntBits(other.dx_f))
				return false;
			if (Float.floatToIntBits(dx_h) != Float.floatToIntBits(other.dx_h))
				return false;
			if (idTable == null) {
				if (other.idTable != null)
					return false;
			} else if (!idTable.equals(other.idTable))
				return false;
			if (Float.floatToIntBits(lx_f) != Float.floatToIntBits(other.lx_f))
				return false;
			if (Float.floatToIntBits(lx_h) != Float.floatToIntBits(other.lx_h))
				return false;
			if (Float.floatToIntBits(px_f) != Float.floatToIntBits(other.px_f))
				return false;
			if (Float.floatToIntBits(px_h) != Float.floatToIntBits(other.px_h))
				return false;
			return true;
		}


		
		
		

}
