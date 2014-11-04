package net.flyingfat.common.serialization.bytebean.codec;

public class DefaultNumberCodecs
{
  private static int b2ui(byte b)
  {
    return (b + 256) % 256;
  }
  
  private static long b2ul(byte b)
  {
    return (b + 256) % 256L;
  }
  
  private static NumberCodec littleEndianCodec = new NumberCodec()
  {
    public int bytes2Int(byte[] bytes, int byteLength)
    {
      int value = 0;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ui(bytes[i]) << i * 8;
      }
      return value;
    }
    
    public long bytes2Long(byte[] bytes, int byteLength)
    {
      long value = 0L;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ul(bytes[i]) << i * 8;
      }
      return value;
    }
    
    public short bytes2Short(byte[] bytes, int byteLength)
    {
      short value = 0;
      for (int i = 0; i < byteLength; i++) {
        value = (short)(value | DefaultNumberCodecs.b2ui(bytes[i]) << i * 8);
      }
      return value;
    }
    
    public float bytes2Float(byte[] bytes, int byteLength)
    {
      int value = 0;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ui(bytes[i]) << i * 8;
      }
      return Float.intBitsToFloat(value);
    }
    
    public double bytes2Double(byte[] bytes, int byteLength)
    {
      long value = 0L;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ul(bytes[i]) << i * 8;
      }
      return Double.longBitsToDouble(value);
    }
    
    public byte[] int2Bytes(int value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = i * 8;
        bytes[i] = ((byte)((value & 255 << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] long2Bytes(long value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = i * 8;
        bytes[i] = ((byte)(int)((value & 255L << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] short2Bytes(short value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = i * 8;
        bytes[i] = ((byte)((value & 255 << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] float2Bytes(float value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      



      int x = Float.floatToRawIntBits(value);
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = i * 8;
        bytes[i] = ((byte)((x & 255 << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] double2Bytes(double value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      

      long x = Double.doubleToRawLongBits(value);
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = i * 8;
        bytes[i] = ((byte)(int)((x & 255L << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public String convertCharset(String charset)
    {
      if (charset.equals("UTF-16")) {
        return "UTF-16LE";
      }
      return charset;
    }
  };
  private static NumberCodec bigEndianCodec = new NumberCodec()
  {
    public int bytes2Int(byte[] bytes, int byteLength)
    {
      int value = 0;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ui(bytes[i]) << (byteLength - 1 - i) * 8;
      }
      return value;
    }
    
    public long bytes2Long(byte[] bytes, int byteLength)
    {
      long value = 0L;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ul(bytes[i]) << (byteLength - 1 - i) * 8;
      }
      return value;
    }
    
    public short bytes2Short(byte[] bytes, int byteLength)
    {
      short value = 0;
      for (int i = 0; i < byteLength; i++) {
        value = (short)(value | DefaultNumberCodecs.b2ui(bytes[i]) << (byteLength - 1 - i) * 8);
      }
      return value;
    }
    
    public float bytes2Float(byte[] bytes, int byteLength)
    {
      int value = 0;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ui(bytes[i]) << (byteLength - 1 - i) * 8;
      }
      return Float.intBitsToFloat(value);
    }
    
    public double bytes2Double(byte[] bytes, int byteLength)
    {
      long value = 0L;
      for (int i = 0; i < byteLength; i++) {
        value |= DefaultNumberCodecs.b2ul(bytes[i]) << (byteLength - 1 - i) * 8;
      }
      return Double.longBitsToDouble(value);
    }
    
    public byte[] int2Bytes(int value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = (byteLength - 1 - i) * 8;
        bytes[i] = ((byte)((value & 255 << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] long2Bytes(long value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = (byteLength - 1 - i) * 8;
        bytes[i] = ((byte)(int)((value & 255L << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] short2Bytes(short value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = (byteLength - 1 - i) * 8;
        bytes[i] = ((byte)((value & 255 << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] float2Bytes(float value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      



      int x = Float.floatToRawIntBits(value);
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = (byteLength - 1 - i) * 8;
        bytes[i] = ((byte)(int)((x & 255L << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public byte[] double2Bytes(double value, int byteLength)
    {
      byte[] bytes = new byte[byteLength];
      

      long x = Double.doubleToRawLongBits(value);
      for (int i = 0; i < byteLength; i++)
      {
        int shiftCount = (byteLength - 1 - i) * 8;
        bytes[i] = ((byte)(int)((x & 255L << shiftCount) >> shiftCount));
      }
      return bytes;
    }
    
    public String convertCharset(String charset)
    {
      if (charset.equals("UTF-16")) {
        return "UTF-16BE";
      }
      return charset;
    }
  };
  
  public static NumberCodec getBigEndianNumberCodec()
  {
    return bigEndianCodec;
  }
  
  public static NumberCodec getLittleEndianNumberCodec()
  {
    return littleEndianCodec;
  }
}
